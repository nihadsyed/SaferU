package com.example.saferu.ui.notifications;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.saferu.R;
import com.example.saferu.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    MediaPlayer mp;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        Spinner alertDrop = (Spinner) root.findViewById(R.id.spinner3);
        Switch list_toggle=(Switch) root.findViewById(R.id.switch2);

        list_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.v("Switch State=", ""+isChecked);
                if (!isChecked){
                    AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Turning off location prevents the application from sending location specific danger notifications.");
                    alertDialog.setCancelable(false);
                    alertDialog.setCanceledOnTouchOutside(false);
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "CANCEL",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    list_toggle.setChecked(true);
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });

        alertDrop.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            int check = 0;
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (view != null && ++check > 1){
                    String selectedItem = adapterView.getItemAtPosition(i).toString();
                    if (selectedItem.equals("Bell")){
                        Log.v("SELECTION",selectedItem);
                        if (mp != null){
                            mp.stop();
                        }
                        mp = MediaPlayer.create(getContext(),R.raw.bell);
                        mp.start();
                    }
                    if (selectedItem.equals("Chimes")){
                        Log.v("SELECTION",selectedItem);
                        if (mp != null){
                            mp.stop();
                        }
                        mp = MediaPlayer.create(getContext(),R.raw.chime);
                        mp.start();
                    }
                    if (selectedItem.equals("Minecraft Villager Noise")){
                        Log.v("SELECTION",selectedItem);
                        if (mp != null){
                            mp.stop();
                        }
                        mp = MediaPlayer.create(getContext(),R.raw.villager);
                        mp.start();
                    }
                    if (selectedItem.equals("Birds")){
                        Log.v("SELECTION",selectedItem);
                        if (mp != null){
                            mp.stop();
                        }
                        mp = MediaPlayer.create(getContext(),R.raw.bird);
                        mp.start();
                    }
                    if (selectedItem.equals("Thud")){
                        Log.v("SELECTION",selectedItem);
                        if (mp != null){
                            mp.stop();
                        }
                        mp = MediaPlayer.create(getContext(),R.raw.thud);
                        mp.start();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        return root;
    }

    @Override
    public void onDestroyView() {
        if (mp != null){
            mp.stop();
            mp.release();
        }
        super.onDestroyView();
        binding = null;
    }
}