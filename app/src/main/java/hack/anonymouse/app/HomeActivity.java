package hack.anonymouse.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import hack.anonymouse.app.data.Items;

public class HomeActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private TabLayout tabLayout;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabs);

        recyclerView = (RecyclerView) findViewById(R.id.list);

        tabLayout.addTab(tabLayout.newTab().setTag(0).setText("Story"));
        tabLayout.addTab(tabLayout.newTab().setTag(1).setText("Conversation"));
        tabLayout.addOnTabSelectedListener(this);

        onTabSelected(tabLayout.getTabAt(tabLayout.getSelectedTabPosition()));
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int id = (int) tab.getTag();
        List<CharSequence> itemList = Items.getItemList(id);
        recyclerView.setAdapter(new ListAdapter(itemList, id));
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }

    public void openStory(View view) {
        if ((int) view.getTag() == 0) {
            startActivity(new Intent(this, StoryActivity.class));
        } else if (tabLayout.getSelectedTabPosition() == 1) {
            openConversation(view);
        }else{
            startActivity(new Intent(this, StoryActivity.class)
                    .putExtra(StoryActivity.STORY, ((TextView) view).getText()));
        }
    }

    public void openConversation(View view) {
        startActivity(new Intent(this, ChatActivity.class));
    }
}
