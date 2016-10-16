package hack.anonymouse.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import hack.anonymouse.app.data.Data;
import hack.anonymouse.app.data.Stories;

public class StoryActivity extends AppCompatActivity {

    static String STORY = "story";

    private TextView textView;
    private EditText editText;
    private Switch publicStory;

    @Override
    @SuppressWarnings("ConstantConditions")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (Intent.ACTION_MAIN.equals(getIntent().getAction())) {
            findViewById(R.id.title).setVisibility(View.VISIBLE);
        } else {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        editText = (EditText) findViewById(R.id.text);
        editText.setText(Stories.MY_STORY);

        publicStory = (Switch) findViewById(R.id.public_story);
        publicStory.setChecked(Data.PUBLIC_STORY);

        textView = (TextView) findViewById(R.id.story);
        textView.setText(getIntent().getStringExtra(STORY));
        if (textView.getText().length() > 0) {
            findViewById(R.id.story_only).setVisibility(View.VISIBLE);
            textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        } else {
            findViewById(R.id.story_edit).setVisibility(View.VISIBLE);
            editText.setSelection(Stories.MY_STORY.length());
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void saveStory(View view) {
        Stories.MY_STORY = editText.getText().toString();
        Data.PUBLIC_STORY = publicStory.isChecked();
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    public void startConversation(View view) {
        startActivity(new Intent(this, ChatActivity.class));
    }
}
