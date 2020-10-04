package th.ac.su.cp.quizgame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import th.ac.su.cp.quizgame.model.WordItem;

public class WordListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_list);

        //สร้าง Layout manager
        LinearLayoutManager lm = new LinearLayoutManager(WordListActivity.this);
        //สร้าง adapter object
        MyAdapter adapter = new MyAdapter(WordListActivity.this);

        //เข้าถึง RecycleView ใน Layout
        RecyclerView rv = findViewById(R.id.word_list_recycler_view);
        rv.setLayoutManager(lm);//อยากให้มี list แบบไหน->กำหนด layout manager ให้กับ recycleView
        rv.setAdapter(adapter);//อยากให้แสดงข้อมูลแบบไหน->กำหนด adapter ให้กับ recycleView


    }
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    final Context mContext;

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

    public MyAdapter(Context context) {
        this.mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_word/*แปลง .xml เป็น java Object*/, parent, false);
        MyViewHolder vh = new MyViewHolder(mContext,v);
        return vh;
    }

    @Override//holder รับ vh
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.imageView.setImageResource(items[position].imageResId);
        holder.wordTextView.setText(items[position].word);
        holder.item = items[position];

    }

    @Override
    public int getItemCount() {
        return items.length;//จำนวนครั้งการเตรียมแสดง item (บอกว่ามีไอเทมทั้งหมดกี่ชิ้น)
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        View rootView;
        ImageView imageView;
        TextView wordTextView;
        WordItem item;

        public MyViewHolder(final Context context,@NonNull View itemView) {
            super(itemView);
            rootView = itemView;
            imageView = itemView.findViewById(R.id.image_view);
            wordTextView = itemView.findViewById(R.id.word_text_view);

            rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, item.word, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(context,WordDetailsActivity.class);
                    context.startActivity(intent);

                    /*AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                    dialog.setTitle("Mydialog");
                    dialog.setMessage(item.word);
                    dialog.setPositiveButton("OK",null);
                    dialog.show();

                    //can do that,method chaining
                    new AlertDialog.Builder(context)
                            .setTitle("my Dialog")
                            .setMessage(item.word)
                            .setPositiveButton("ok",null)
                            .show();*/
                }
            });
        }
    }
}