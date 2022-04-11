package com.gzeinnumer.fragmentoptionmenu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu1:
                Toast.makeText(requireContext(), "Menu 1 ", Toast.LENGTH_SHORT).show();
                Fragment fragment = new Menu1Fragment();
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fr_1, fragment)
                        .commit();
                return true;
            default: 
                return super.onOptionsItemSelected(item);

        }
    }

    private static final String TAG = "assfasfasfsafasda";

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        AppDatabase database =
                Room.databaseBuilder(requireContext(), AppDatabase.class, "database-name")
                        .build();

        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                UserDao userDao = database.userDao();
                List<User> users = userDao.getAll();
                Log.d(TAG, "run1: "+users.size());
                userDao.deleteAll();

                userDao.insertAll(new User(1,"Zein", "Aja"));
                users = userDao.getAll();
                Log.d(TAG, "run2: "+users.size());
                userDao.deleteAll();

                userDao.insertAll(
                        new User(2, "Data 2", "Data 2.2"),
                        new User(3, "Data 2", "Data 2.2"),
                        new User(4, "Data 2", "Data 2.2"),
                        new User(5, "Data 2", "Data 2.2")
                );

                users = userDao.getAll();
                Log.d(TAG, "run3: "+users.size());
                userDao.deleteAll();

                for (int i = 0; i < users.size(); i++) {
                    Log.d(TAG, "run: "+users.get(i).toString());
                }

            }
        });

    }
}