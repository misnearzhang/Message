package com.syuct.zhanglong.message4u;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by zhanglong on 4/12/15.
 */
public class NewsDetailActivity extends Activity {
    private Button close;
    private LinearLayout linearLayout;
    private ProgressDialog dialog;
    private TextView textView;
    public static String news=new String("　　中新社华盛顿4月11日电 (记者 张蔚然)美国国土安全部当地时间11日表示，约翰逊部长近日访华期间与中方达成一致意见，" +
            "美方同意精简遣返中国贪官的流程。\n" +
            "　　国土安全部当天发表声明说，本月9日至10日，约翰逊对中国进行首次访问，就反恐、海关、移民、网络安全等共同关心的问题与中方进行讨论，" +
            "这是时隔9年后美国土安全部部长首次访华。" +
            "期间约翰逊与中共中央政治局委员、中央政法委书记孟建柱、中国国务委员、公安部部长郭声琨等官员举行会晤。\n" +
            "　　约翰逊表示，此次访问中，双方同意在达成一致的领域推进合作，同时就分歧“坦诚交换了意见”。\n" +
            "\n" +
            "　　声明说，约翰逊与中方官员同意精简遣返收到最终递解令的中国公民的流程。美国海关与移民执法局将与中国公安部密切合作，" +
            "核实申请旅行证件的中国公民的身份，同时确保安排定期包机计划，促进遣返工作。\n" +
            "　　中共十八大以来，新一届中央领导集体坚持以零容忍态度惩治腐败，展开大规模海外追逃追赃行动。" +
            "中国最高检反贪总局上月透露，中方已向美国提供一份追逃“优先名单”，请求美方协助追捕，据信名单上的人都藏匿在美国。" +
            "美国国务院则表示鼓励中方提供强有力证据和情报，确保美执法机构调查和起诉涉嫌腐败的案件。中美双方同意，" +
            "任何一方都不会为逃犯提供庇护，将在各自法律范围内，努力将其实施遣返。(完)"+
            "　　中新社华盛顿4月11日电 (记者 张蔚然)美国国土安全部当地时间11日表示，约翰逊部长近日访华期间与中方达成一致意见，" +
                    "美方同意精简遣返中国贪官的流程。\n" +
                    "　　国土安全部当天发表声明说，本月9日至10日，约翰逊对中国进行首次访问，就反恐、海关、移民、网络安全等共同关心的问题与中方进行讨论，" +
                    "这是时隔9年后美国土安全部部长首次访华。" +
                    "期间约翰逊与中共中央政治局委员、中央政法委书记孟建柱、中国国务委员、公安部部长郭声琨等官员举行会晤。\n" +
                    "　　约翰逊表示，此次访问中，双方同意在达成一致的领域推进合作，同时就分歧“坦诚交换了意见”。\n" +
                    "\n" +
                    "　　声明说，约翰逊与中方官员同意精简遣返收到最终递解令的中国公民的流程。美国海关与移民执法局将与中国公安部密切合作，" +
                    "核实申请旅行证件的中国公民的身份，同时确保安排定期包机计划，促进遣返工作。\n" +
                    "　　中共十八大以来，新一届中央领导集体坚持以零容忍态度惩治腐败，展开大规模海外追逃追赃行动。" +
                    "中国最高检反贪总局上月透露，中方已向美国提供一份追逃“优先名单”，请求美方协助追捕，据信名单上的人都藏匿在美国。" +
                    "美国国务院则表示鼓励中方提供强有力证据和情报，确保美执法机构调查和起诉涉嫌腐败的案件。中美双方同意，" +
                    "任何一方都不会为逃犯提供庇护，将在各自法律范围内，努力将其实施遣返。(完)"+
            "　　中新社华盛顿4月11日电 (记者 张蔚然)美国国土安全部当地时间11日表示，约翰逊部长近日访华期间与中方达成一致意见，" +
                    "美方同意精简遣返中国贪官的流程。\n" +
                    "　　国土安全部当天发表声明说，本月9日至10日，约翰逊对中国进行首次访问，就反恐、海关、移民、网络安全等共同关心的问题与中方进行讨论，" +
                    "这是时隔9年后美国土安全部部长首次访华。" +
                    "期间约翰逊与中共中央政治局委员、中央政法委书记孟建柱、中国国务委员、公安部部长郭声琨等官员举行会晤。\n" +
                    "　　约翰逊表示，此次访问中，双方同意在达成一致的领域推进合作，同时就分歧“坦诚交换了意见”。\n" +
                    "\n" +
                    "　　声明说，约翰逊与中方官员同意精简遣返收到最终递解令的中国公民的流程。美国海关与移民执法局将与中国公安部密切合作，" +
                    "核实申请旅行证件的中国公民的身份，同时确保安排定期包机计划，促进遣返工作。\n" +
                    "　　中共十八大以来，新一届中央领导集体坚持以零容忍态度惩治腐败，展开大规模海外追逃追赃行动。" +
                    "中国最高检反贪总局上月透露，中方已向美国提供一份追逃“优先名单”，请求美方协助追捕，据信名单上的人都藏匿在美国。" +
                    "美国国务院则表示鼓励中方提供强有力证据和情报，确保美执法机构调查和起诉涉嫌腐败的案件。中美双方同意，" +
                    "任何一方都不会为逃犯提供庇护，将在各自法律范围内，努力将其实施遣返。(完)"+
            "　　中新社华盛顿4月11日电 (记者 张蔚然)美国国土安全部当地时间11日表示，约翰逊部长近日访华期间与中方达成一致意见，" +
                    "美方同意精简遣返中国贪官的流程。\n" +
                    "　　国土安全部当天发表声明说，本月9日至10日，约翰逊对中国进行首次访问，就反恐、海关、移民、网络安全等共同关心的问题与中方进行讨论，" +
                    "这是时隔9年后美国土安全部部长首次访华。" +
                    "期间约翰逊与中共中央政治局委员、中央政法委书记孟建柱、中国国务委员、公安部部长郭声琨等官员举行会晤。\n" +
                    "　　约翰逊表示，此次访问中，双方同意在达成一致的领域推进合作，同时就分歧“坦诚交换了意见”。\n" +
                    "\n" +
                    "　　声明说，约翰逊与中方官员同意精简遣返收到最终递解令的中国公民的流程。美国海关与移民执法局将与中国公安部密切合作，" +
                    "核实申请旅行证件的中国公民的身份，同时确保安排定期包机计划，促进遣返工作。\n" +
                    "　　中共十八大以来，新一届中央领导集体坚持以零容忍态度惩治腐败，展开大规模海外追逃追赃行动。" +
                    "中国最高检反贪总局上月透露，中方已向美国提供一份追逃“优先名单”，请求美方协助追捕，据信名单上的人都藏匿在美国。" +
                    "美国国务院则表示鼓励中方提供强有力证据和情报，确保美执法机构调查和起诉涉嫌腐败的案件。中美双方同意，" +
                    "任何一方都不会为逃犯提供庇护，将在各自法律范围内，努力将其实施遣返。(完)"+
            "　　中新社华盛顿4月11日电 (记者 张蔚然)美国国土安全部当地时间11日表示，约翰逊部长近日访华期间与中方达成一致意见，" +
                    "美方同意精简遣返中国贪官的流程。\n" +
                    "　　国土安全部当天发表声明说，本月9日至10日，约翰逊对中国进行首次访问，就反恐、海关、移民、网络安全等共同关心的问题与中方进行讨论，" +
                    "这是时隔9年后美国土安全部部长首次访华。" +
                    "期间约翰逊与中共中央政治局委员、中央政法委书记孟建柱、中国国务委员、公安部部长郭声琨等官员举行会晤。\n" +
                    "　　约翰逊表示，此次访问中，双方同意在达成一致的领域推进合作，同时就分歧“坦诚交换了意见”。\n" +
                    "\n" +
                    "　　声明说，约翰逊与中方官员同意精简遣返收到最终递解令的中国公民的流程。美国海关与移民执法局将与中国公安部密切合作，" +
                    "核实申请旅行证件的中国公民的身份，同时确保安排定期包机计划，促进遣返工作。\n" +
                    "　　中共十八大以来，新一届中央领导集体坚持以零容忍态度惩治腐败，展开大规模海外追逃追赃行动。" +
                    "中国最高检反贪总局上月透露，中方已向美国提供一份追逃“优先名单”，请求美方协助追捕，据信名单上的人都藏匿在美国。" +
                    "美国国务院则表示鼓励中方提供强有力证据和情报，确保美执法机构调查和起诉涉嫌腐败的案件。中美双方同意，" +
                    "任何一方都不会为逃犯提供庇护，将在各自法律范围内，努力将其实施遣返。(完)");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdetail);
        textView=new TextView(this);
        dialog=new ProgressDialog(this);
        dialog.setTitle("提示");
        dialog.setMessage("正在加载....");
        linearLayout=(LinearLayout)findViewById(R.id.news);
        GetMsg n=new GetMsg();
        n.execute("");


        linearLayout.addView(textView);
        close = (Button) findViewById(R.id.closeButton);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                overridePendingTransition(R.anim.abc_slide_in_top, R.anim.abc_slide_out_bottom);
            }
        });
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.abc_slide_in_top, R.anim.abc_slide_out_bottom);
    }
    class GetMsg extends AsyncTask<String,Void,String>{
        @Override
        protected String doInBackground(String... params) {
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            return news;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setText(s);
            textView.setTextSize(20f);
            dialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}