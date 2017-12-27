package alfianagramerry.mobpro.tugasbesar.androidtutorial.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import alfianagramerry.mobpro.tugasbesar.androidtutorial.ProgramLain.GyroscopeSensor.GyroscopeSensor;
import alfianagramerry.mobpro.tugasbesar.androidtutorial.R;

/**
 * Created by Alfian Hadi Pratama on 25/12/2017.
 */

public class Data2 extends RecyclerView.Adapter<Data2.ViewHolder> {

    private ArrayList<ListData> listData;
    private Context context;

    public Data2(Context context, ArrayList<ListData> listData) {
        this.listData = listData;
        this.context = context;
    }

    @Override
    public Data2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_view, parent, false));
    }

    @Override
    public void onBindViewHolder(Data2.ViewHolder holder, int position) {
        ListData currentData = listData.get(position);
        holder.bindTo(currentData);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView;

        private ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.title);
            itemView.setOnClickListener(this);
            context = itemView.getContext();
        }

        void bindTo(ListData currentList) {
            textView.setText(currentList.getTitle());
        }

        @Override
        public void onClick(View view) {

            final Intent intent;
            switch (getAdapterPosition()) {
                case 0:
                    intent = new Intent(context, GyroscopeSensor.class);
                    break;

                case 1:
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.youtube.com"));
                    break;

                default:
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.facebook.com"));
                    break;
            }
            context.startActivity(intent);

        }
    }
}
