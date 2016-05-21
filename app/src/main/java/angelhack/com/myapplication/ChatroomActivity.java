package angelhack.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by victor_li on 21/5/2016.
 */
public class ChatroomActivity extends AppCompatActivity {

    ListView listView;
    ImageView imgView;
    ChatroomListViewAdapter adapter;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatroom_activity);

        listView = (ListView) findViewById(R.id.lv);
        adapter = new ChatroomListViewAdapter();
        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                adapter.getNewDialog();
//                listView.invalidate();
//                listView.setSelection(adapter.getCount() - 1);
//            }
//        });

        button = (Button) findViewById(R.id.btn);
//        button.setVisibility(View.GONE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.getNewDialog();
                listView.invalidate();
                listView.setSelection(adapter.getCount() - 1);
            }
        });
    }

//    public class ChatroomData {
//
//        private String[] chatList = new String[] {
//                "AAA11 \n11134234215231",
//                "BBBB \nsdwfa ",
//                "CCCC \nscscascasasaaa",
//                "CDSF \nscscascasasaaa",
//                "FEEWF \nscscascasasaaa",
//                "ASFDFFVS scscascasasaaa",
//                "AEREQLJLI \nscscascasasaaa",
//        };
//
//        public ArrayList<String> data = new ArrayList<String>();
//
//        public void getDialog() {
//            if (data.size() < chatList.length) {
//                data.add(chatList[data.size()]);
//            }
//        }
//    }

    public class ChatroomListViewAdapter extends BaseAdapter {

        ChatroomData chatroomData = ChatroomData.getInstance();

        public ChatroomListViewAdapter() {
            chatroomData.getDialog();
        }

        public void getNewDialog() {
            chatroomData.getDialog();
        }

        @Override
        public int getCount() {
            return chatroomData.data.size();
        }

        @Override
        public String getItem(int position) {
            return chatroomData.data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.chatroom_item, parent, false);

            TextView bubbleLeft = (TextView) row.findViewById(R.id.tv_left);
            TextView bubbleRight = (TextView) row.findViewById(R.id.tv_right);
            bubbleLeft.setVisibility(View.GONE);
            bubbleRight.setVisibility(View.GONE);
            if (position % 2 == 0) {
                bubbleLeft.setText(getItem(position));
                bubbleLeft.setVisibility(View.VISIBLE);
            } else {
                bubbleRight.setText(getItem(position));
                bubbleRight.setVisibility(View.VISIBLE);
            }
            return row;
        }
    }
}
