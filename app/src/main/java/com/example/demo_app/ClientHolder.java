package com.example.demo_app;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class ClientHolder extends RecyclerView.ViewHolder {
    View view;
    public ClientHolder(@NonNull View itemView) {
        super(itemView);

        view = itemView;
    }

    public void setView(Context context , String ClientName, String category )
    {
        TextView ClientNametv= view.findViewById(R.id.ClientName_tv);
        TextView categorytv= view.findViewById(R.id.Category_tv);

        ClientNametv.setText(ClientName);
        categorytv.setText(category);

    }
}
