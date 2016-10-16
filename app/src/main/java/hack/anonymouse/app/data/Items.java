package hack.anonymouse.app.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Items {

    private Items() {
    }

    public static List<CharSequence> getItemList(int which) {
        ArrayList<CharSequence> list = new ArrayList<>();
        switch (which) {
            case 0:
                list.add(Stories.MY_STORY);
                list.add("Similar stories");
                list.addAll(Arrays.asList(Stories.STORY_2, Stories.STORY_4, Stories.STORY_6, Stories.STORY_5, Stories.STORY_1));
                break;
            case 1:
                list.add("Thank you for sharing your story!");
                list.add("\t[...]\nI had the same experience once.");
        }
        return list;
    }
}
