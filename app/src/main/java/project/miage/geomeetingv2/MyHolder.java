package project.miage.geomeetingv2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by Ilias on 07/11/2018.
 */

public class MyHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        TextView nom, telephone;
        CheckBox chkbx;

        ItemClickListener itemClickListenser;

public MyHolder(View itemView) {
        super(itemView);

        nom = (TextView) itemView.findViewById(R.id.customName);
        telephone = (TextView) itemView.findViewById(R.id.customNumber);
        chkbx = (CheckBox) itemView.findViewById(R.id.chkbox);

        chkbx.setOnClickListener(this);
        }

public void setItemClickListenser(ItemClickListener icl){
        this.itemClickListenser=icl;
        }


@Override
public void onClick(View view) {
        this.itemClickListenser.onItemclick(view, getLayoutPosition());
        }
}
