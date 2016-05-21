package angelhack.com.myapplication;

import java.util.ArrayList;

/**
 * Created by victor_li on 21/5/2016.
 */
public class ChatroomData {

    private static ChatroomData _instance;

    public static ChatroomData getInstance() {
        if (_instance == null) {
            _instance = new ChatroomData();
        }
        return _instance;
    }

    private String[] chatList = new String[] {
            "AAA11 \n11134234215231",
            "BBBB \nsdwfa ",
            "CCCC \nscscascasasaaa",
            "CDSF \nscscascasasaaa",
            "FEEWF \nscscascasasaaa",
            "ASFDFFVS scscascasasaaa",
            "AEREQLJLI \nscscascasasaaa",
    };

    public ArrayList<String> data = new ArrayList<String>();

    public void getDialog() {
        if (data.size() < chatList.length) {
            data.add(chatList[data.size()]);
        }
    }
}