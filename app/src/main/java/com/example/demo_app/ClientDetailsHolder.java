package com.example.demo_app;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ClientDetailsHolder extends RecyclerView.ViewHolder {
    View view;
    public ClientDetailsHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
    }

    public void setView(Context context , String client , int mtApayer )
    {
        TextView clienttv= view.findViewById(R.id.Client_tv);
        TextView mttv= view.findViewById(R.id.MtPay);

        clienttv.setText(client);
        mttv.setText(""+mtApayer);

    }
}
