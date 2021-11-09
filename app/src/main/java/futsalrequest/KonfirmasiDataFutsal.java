package futsalrequest;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.appbookadmin.History;
import com.example.appbookadmin.MenuAdmin;
import com.example.appbookadmin.R;
import com.google.android.material.snackbar.Snackbar;

public class KonfirmasiDataFutsal extends AppCompatActivity {

    Order order = null;
    Button BtnSend, BtnConfirm;
    TextView NamaPemesan, NomorPonsel, TanggalBermain, JamBermain, Email, Durasi, JenisLapangan;
    EditText Status, TotalHarga;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.konfirmasidatafutsal);

        History his = new History();

        BtnSend = findViewById(R.id.btnsend);
        BtnConfirm = findViewById(R.id.btnKonfirmasi);


        final Object object = getIntent().getSerializableExtra("email");
        if (object instanceof Order) {
            order = (Order) object;
            NamaPemesan = findViewById(R.id.namaorder);
            NomorPonsel = findViewById(R.id.hporder);
            TanggalBermain = findViewById(R.id.tanggalorder);
            JamBermain = findViewById(R.id.jamorder);
            Email = findViewById(R.id.emailorder);
            Durasi = findViewById(R.id.durasiorder);
            Status = findViewById(R.id.Status);
            TotalHarga = findViewById(R.id.HargaLapangan);
            JenisLapangan = findViewById(R.id.JenisLapangan);

            if (order != null) {

                NamaPemesan.setText(order.getNama());
                Email.setText(order.getEmail());
                NomorPonsel.setText(order.getNomorponsel());
                TanggalBermain.setText(order.getTanggalbermain());
                JamBermain.setText(order.getJambermain());
                Durasi.setText(order.getLamabermain());
                Status.setText((order.getStatus()));
                TotalHarga.setText((order.getHarga()));
                JenisLapangan.setText((order.getLapangan()));
            }


            BtnConfirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if(!Email.getText().toString().isEmpty() && !NamaPemesan.getText().toString().isEmpty()
                    && !JenisLapangan.getText().toString().isEmpty()) {
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{Email.getText().toString()});
                        intent.putExtra(Intent.EXTRA_SUBJECT, "INVOICE");
                        intent.putExtra(Intent.EXTRA_TEXT, "Halo, "+NamaPemesan.getText().toString()+
                                "\n"+
                                "\n"+"Pesanan Anda telah TERKONFIRMASI \nTanggal bermain : "+TanggalBermain.getText().toString()+
                                "\n"+"Pukul : "+JamBermain.getText().toString()+
                                "\n"+"Lama Bermain : "+Durasi.getText().toString()+" Jam"+
                                "\n"+
                                "\n"+"Kode booking : #"+NomorPonsel.getText().toString()+TanggalBermain.getText().toString()+
                                "\n"+
                                "\n"+
                                "\n"+
                                "\n"+"Note: Silahkan Datang 15 Menit Sebelum Mulai Waktu Bermain"
                        );
                        intent.setType("message/rfc822");
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        } else {
                            Toast.makeText(KonfirmasiDataFutsal.this, "There is no", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                            Toast.makeText(KonfirmasiDataFutsal.this, "There is no Applications",Toast.LENGTH_SHORT).show();
                        }
                    }


            });



            BtnSend.setOnClickListener(v -> {

                Order lapangan = new Order(
                        NamaPemesan.getText().toString(),
                        NomorPonsel.getText().toString(),
                        TanggalBermain.getText().toString(),
                        JamBermain.getText().toString(),
                        Durasi.getText().toString(),
                        Email.getText().toString(),
                        Status.getText().toString(),
                        TotalHarga.getText().toString(),
                        JenisLapangan.getText().toString());
//                        StatusPembayaran.getText().toString();

                his.add(lapangan).addOnSuccessListener(suc -> {
                    Toast.makeText(this, "Berhasil Terkirim", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(er -> {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });


            });
//
//        History history=new History();
//
//        ButtonKirim = findViewById(R.id.btnsend);
//
//
//        ButtonKirim.setOnClickListener(v -> {
//            Order his =new Order(NamaPemesan.getText().toString(), NomorPonsel.getText().toString(), TanggalBermain.getText().toString(),
//                    JamBermain.getText().toString(), Email.getText().toString(), Durasi.getText().toString(), Status.getText().toString());
//            history.add(his).addOnSuccessListener(suc ->{
//                Toast.makeText(this, "Berhasil Dikirim", Toast.LENGTH_SHORT).show();
//            }).addOnFailureListener(er -> {
//                Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
//            });
//        });

        }
    }
}
