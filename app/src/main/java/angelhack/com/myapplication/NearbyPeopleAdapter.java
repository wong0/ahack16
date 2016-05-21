package angelhack.com.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import angelhack.com.model.Employee;

/**
 * Created by tanky on 21/5/2016.
 */
public class NearbyPeopleAdapter extends BaseAdapter {
    private Activity context;
    private List<Employee> employees;

    public NearbyPeopleAdapter(Activity context, List<Employee> employees) {
        this.context = context;
        this.employees = employees;
    }

    @Override
    public int getCount() {
        return employees.size();
    }

    @Override
    public Object getItem(int position) {
        return employees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(R.layout.nearbypeople_item, parent, false);

        de.hdodenhof.circleimageview.CircleImageView ivAvatar = (de.hdodenhof.circleimageview.CircleImageView) row.findViewById(R.id.ivAvatar);
        TextView tvName = (TextView) row.findViewById(R.id.tvName);
        ImageView ivThumbs = (ImageView) row.findViewById(R.id.ivThumbs);
        TextView tvThumbs = (TextView) row.findViewById(R.id.tvThumbs);
        TextView tvSaves = (TextView) row.findViewById(R.id.tvSaves);
        TextView tvDist = (TextView) row.findViewById(R.id.tvDist);


        tvName.setText(employees.get(position).name);
        ivAvatar.setImageDrawable(context.getResources().getDrawable(employees.get(position).avatar));

        tvThumbs.setText(String.valueOf(employees.get(position).thumbs));
        tvSaves.setText(String.valueOf(employees.get(position).saves));
        tvDist.setText(String.valueOf(employees.get(position).dist));


        return row;
    }
}

