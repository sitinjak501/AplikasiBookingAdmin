package futsalrequest;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appbookadmin.R;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;


public class AdapterOrder extends RecyclerView.Adapter<AdapterOrder.MyViewHolder> implements View.OnClickListener {
    Context context;
    ArrayList<Order> list;
    Button BtnSend;


    public AdapterOrder(Context context, ArrayList<Order> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.orderfutsal, parent, false);
        v.setOnClickListener(this);
        return new MyViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, final int position) {


        Order fts = list.get(position);

        holder.fullname.setText(fts.getNama());
        holder.emailorder.setText(fts.getEmail());
        holder.nomorhp.setText(fts.getNomorponsel());
        holder.tanggalbermain.setText(fts.getTanggalbermain());
        holder.jambermain.setText(fts.getJambermain());
        holder.durasibermain.setText(fts.getLamabermain());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, KonfirmasiDataFutsal.class);
            intent.putExtra("email", list.get(position));
            context.startActivity(intent);

////
//            TextView NamaText;
//            TextView EmailText;
//            TextView NomorhpText;
//            TextView TanggalText;
//            TextView JamText;
//            TextView DurasiText;
//            EditText Status;
//
//            NamaText = dialogView.findViewById(R.id.namaorder);
//            EmailText = dialogView.findViewById(R.id.emailorder);
//            NomorhpText = dialogView.findViewById(R.id.hporder);
//            TanggalText = dialogView.findViewById(R.id.tanggalorder);
//            JamText = dialogView.findViewById(R.id.jamorder);
//            DurasiText = dialogView.findViewById(R.id.durasiorder);
//            Status = dialogView.findViewById(R.id.Status);
//
//            NamaText.setText(fts.getNama());
//            EmailText.setText(fts.getEmail());
//            NomorhpText.setText(fts.getNomorponsel());
//            TanggalText.setText(fts.getTanggalbermain());
//            JamText.setText(fts.getJambermain());
//            DurasiText.setText(fts.getLamabermain());
//            Status.setText((fts.getStatus()));
//
//
//            builder.setView(dialogView);
//            builder.setCancelable(true);
//            builder.show();
//
////            History history=new History();
////            BtnSend.setOnClickListener(v1 -> {
////                Order his =new Order(NamaText.getText().toString(),
////                        NomorhpText.getText().toString(),
////                        TanggalText.getText().toString(),
////                        JamText.getText().toString(),
////                        EmailText.getText().toString(),
////                        DurasiText.getText().toString(),
////                        Status.getText().toString());
////                history.add(his);
////
////            });
//        });
    });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnsend:
                return;
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView fullname, emailorder, nomorhp, tanggalbermain, jambermain, durasibermain, lapangan;



        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            fullname = itemView.findViewById(R.id.NamaUser);
            emailorder = itemView.findViewById(R.id.EmaiUser);
            nomorhp = itemView.findViewById(R.id.HpUser);
            tanggalbermain = itemView.findViewById(R.id.TanggalUser);
            jambermain = itemView.findViewById(R.id.JamUser);
            durasibermain = itemView.findViewById(R.id.DurasiUser);
            lapangan = itemView.findViewById(R.id.JenisLapangan);

        }
    }
}

