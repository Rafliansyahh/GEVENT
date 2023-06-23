package pab2.uas.rafliansyah.gevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import pab2.uas.rafliansyah.gevent.databinding.ActivityUpdateUnggahBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateUnggahActivity extends AppCompatActivity {
    private ActivityUpdateUnggahBinding binding;
    private Unggah unggah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityUpdateUnggahBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        unggah = getIntent().getParcelableExtra("EXTRA_DATA");
        String id = unggah.getId();

        binding.etNamaevent.setText(unggah.getNamaevent());
        binding.etAlamat.setText(unggah.getAlamat());
        binding.etDeskripsi.setText(unggah.getDeskripsi());

        binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaevent = binding.etNamaevent.getText().toString();
                String alamat = binding.etAlamat.getText().toString();
                String deskripsi = binding.etDeskripsi.getText().toString();

                boolean bolehUpdate = true;
                if (TextUtils.isEmpty(namaevent)){
                    bolehUpdate =false;
                    binding.etNamaevent.setError("Nama Barang Tidak Boleh Kosong");
                }
                if (TextUtils.isEmpty(alamat)){
                    bolehUpdate =false;
                    binding.etAlamat.setError("Alamat Tidak Boleh Kosong");
                }
                if (TextUtils.isEmpty(deskripsi)){
                    bolehUpdate =false;
                    binding.etDeskripsi.setError("Deskripsi Tidak Boleh Kosong");
                }
                if (bolehUpdate){
                    updateUnggah(id,namaevent,alamat,deskripsi);
                }
            }
        });

    }

    private void updateUnggah(String id, String namaevent, String alamat, String deskripsi) {
        binding.progressBar.setVisibility(View.VISIBLE);
        APIService api = Utilities.getRetrofit().create(APIService.class);
        Call<ValueNoData> call = api.updateUnggah(id, namaevent, alamat, deskripsi);
        call.enqueue(new Callback<ValueNoData>() {
            @Override
            public void onResponse(Call<ValueNoData> call, Response<ValueNoData> response) {
                binding.progressBar.setVisibility(View.GONE);
                if (response.code() == 200) {
                    int success = response.body().getSuccess();
                    String message = response.body().getMessage();

                    if (success == 1) {
                        Toast.makeText(UpdateUnggahActivity.this, message, Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(UpdateUnggahActivity.this, message, Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(UpdateUnggahActivity.this, "Response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ValueNoData> call, Throwable t) {
                binding.progressBar.setVisibility(View.GONE);
                System.out.println("Retrofit Error :" + t.getMessage());
                Toast.makeText(UpdateUnggahActivity.this, "Retrofit Error :" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}