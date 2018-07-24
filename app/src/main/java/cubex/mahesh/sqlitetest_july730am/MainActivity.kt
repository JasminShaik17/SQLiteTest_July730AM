package cubex.mahesh.sqlitetest_july730am

import android.content.ContentValues
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var dBase = openOrCreateDatabase("emp_db",
                Context.MODE_PRIVATE,null)
        dBase.execSQL("create table if not exists employee(_id integer primary key autoincrement,emp_id number,name varchar(100),desig varchar(100),dept varchar(100) )")

        insert.setOnClickListener({
            // insert into employee values (123,'Mahesh','TL','Mobility')
  // String table, String nullColumnHack, ContentValues values
            var cv = ContentValues()
            cv.put("emp_id",et1.text.toString().toInt())
            cv.put("name",et2.text.toString())
            cv.put("desig",et3.text.toString())
            cv.put("dept",et4.text.toString())
            var status = dBase.insert("employee",
                    null,cv)
            if(status!=-1.toLong()){
                Toast.makeText(this@MainActivity,
                        "Data Insertion is Success...",
                        Toast.LENGTH_LONG).show()
       et1.setText("");et2.setText("")
                et3.setText("");et4.setText("")
            }else{
                Toast.makeText(this@MainActivity,
                        "Data Insertion is Failed...",
                        Toast.LENGTH_LONG).show()
            }
        })

    }
}
