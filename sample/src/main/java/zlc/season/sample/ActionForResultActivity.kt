package zlc.season.sample

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_action_for_result.*
import zlc.season.rxrouter.RxRouter

class ActionForResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_action_for_result)

        RxRouter.data(intent)
                .subscribe {
                    int_value.text = "传入的int参数为：${it.intValue}"
                    long_value.text = "传入的long参数为：${it.longValue}"
                    boolean_value.text = "传入的boolean参数为：${it.booleanValue}"
                    double_value.text = "传入的double参数为：${it.doubleValue}"
                    string_value.text = "传入的string参数为：${it.stringValue}"
                    bundle_value.text = "传入的bundle参数为：${it.bundle.toString()}"
                }
    }

    override fun finish() {
        val resultIntent = Intent()
        resultIntent.putExtra("result", "This is result!")
        setResult(Activity.RESULT_OK, resultIntent)

        super.finish()
    }

}
