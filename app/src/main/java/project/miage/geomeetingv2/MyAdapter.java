package project.miage.geomeetingv2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Ilias on 07/11/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context context;
    ArrayList<Contact> contacts;

    ArrayList<Contact> checkedContacts = new ArrayList<>();

    public MyAdapter(Context context, ArrayList<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_custom_layout, null);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.nom.setText(contacts.get(position).getNom());
        holder.telephone.setText(contacts.get(position).getTelephone());

        holder.setItemClickListenser(new ItemClickListener() {

            @Override
            public void onItemclick(View view, int position) {
                CheckBox chkbx = (CheckBox)view;

                if (chkbx.isChecked()){
                    checkedContacts.add(contacts.get(position));
                }else if (!chkbx.isChecked()){
                    checkedContacts.remove(contacts.get(position));
                }

            }
        });
    }


    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public ArrayList<Contact> getCheckedContacts() {
        return checkedContacts;
    }
}
