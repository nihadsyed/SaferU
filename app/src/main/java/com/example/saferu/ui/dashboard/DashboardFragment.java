package com.example.saferu.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.saferu.R;
import com.example.saferu.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        View inflatedView = inflater.inflate(R.layout.fragment_home,container,false);
        TextView mapText = (TextView) inflatedView.findViewById(R.id.timer_text);

        Button dayButton = (Button) root.findViewById(R.id.button);
        Button weekButton = (Button) root.findViewById(R.id.button2);
        Button monthButton = (Button) root.findViewById(R.id.button3);
        Button customButton = (Button) root.findViewById(R.id.button4);
        CalendarView calendar = (CalendarView) root.findViewById(R.id.calendarView);
        calendar.setVisibility(View.INVISIBLE);
        dayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mapText.setText("Viewing Past 69 Hours");
                dayButton.setBackgroundColor(getResources().getColor(R.color.green));
                weekButton.setBackgroundColor(getResources().getColor(R.color.gray));
                monthButton.setBackgroundColor(getResources().getColor(R.color.gray));
                customButton.setBackgroundColor(getResources().getColor(R.color.gray));
                calendar.setVisibility(View.INVISIBLE);
            }
        });

        weekButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              mapText.setText("Viewing Past 69 Hours");
                dayButton.setBackgroundColor(getResources().getColor(R.color.gray));
                weekButton.setBackgroundColor(getResources().getColor(R.color.green));
                monthButton.setBackgroundColor(getResources().getColor(R.color.gray));
                customButton.setBackgroundColor(getResources().getColor(R.color.gray));
                calendar.setVisibility(View.INVISIBLE);
            }
        });

        monthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              mapText.setText("Viewing Past 69 Hours");
                dayButton.setBackgroundColor(getResources().getColor(R.color.gray));
                weekButton.setBackgroundColor(getResources().getColor(R.color.gray));
                monthButton.setBackgroundColor(getResources().getColor(R.color.green));
                customButton.setBackgroundColor(getResources().getColor(R.color.gray));
                calendar.setVisibility(View.INVISIBLE);
            }
        });

        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              mapText.setText("Viewing Past 69 Hours");
                dayButton.setBackgroundColor(getResources().getColor(R.color.gray));
                weekButton.setBackgroundColor(getResources().getColor(R.color.gray));
                monthButton.setBackgroundColor(getResources().getColor(R.color.gray));
                customButton.setBackgroundColor(getResources().getColor(R.color.green));
                calendar.setVisibility(View.VISIBLE);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}