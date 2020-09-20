package th.ac.su.cp.quizgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import th.ac.su.cp.quizgame.model.WordItem;

public class WordListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        //สร้าง Layout manager
        LinearLayoutManager lm =new LinearLayoutManager(WordListActivity.this);
        //สร้าง adapter object
        MyAdapter adapter = new MyAdapter();

        //เข้าถึง RecycleView ใน Layout
        RecyclerView rv = findViewById(R.id.word_list_recycler_view);
        rv.setLayoutManager(lm);//อยากให้มี list แบบไหน->กำหนด layout manager ให้กับ recycleView
        rv.setAdapter(adapter);//อยากให้แสดงข้อมูลแบบไหน->กำหนด adapter ให้กับ recycleView

    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        WordItem[] items = {
                new WordItem(R.drawable.cat, "CAT"),
                new WordItem(R.drawable.dog, "DOG"),
                new WordItem(R.drawable.dolphin, "DOLPHIN"),
                new WordItem(R.drawable.koala, "KOALA"),
                new WordItem(R.drawable.lion, "LION"),
                new WordItem(R.drawable.owl, "OWL"),
                new WordItem(R.drawable.penguin, "PENGUIN"),
                new WordItem(R.drawable.pig, "PIG"),
                new WordItem(R.drawable.rabbit, "RABBIT"),
                new WordItem(R.drawable.tiger, "TIGER")
        };

        public MyAdapter() {

        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_word/*บอกรูปแบบการแสดงผล*/, parent, false);
            MyViewHolder vh = new MyViewHolder(v);
            return vh;
        }
        @Override//holder รับ vh
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
                holder.imageView.setImageResource(items[position].imageResId);
                holder.wordTextView.setText(items[position].word);
        }

        @Override
        public int getItemCount() {
            return items.length;//จำนวนครั้งการเตรียมแสดง item (บอกว่ามีไอเทมทั้งหมดกี่ชิ้น)
        }
        class MyViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;
            TextView wordTextView;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.image_view);
                wordTextView = itemView.findViewById(R.id.word_text_view);
            }
        }
    }
}