package com.example.dmitriyl.helloworld.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.dmitriyl.helloworld.R;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayersFragment extends ListFragment
{
    String[] players={"Ander Herera","Diego Costa","Juan Mata","David De Gea","Thibaut Courtouis","Van Persie","Oscar"};
    int[] images={  R.drawable.ic_access_time_white_24dp,
                    R.drawable.ic_access_time_white_24dp,
                    R.drawable.ic_access_time_white_24dp,
                    R.drawable.ic_access_time_white_24dp,
                    R.drawable.ic_access_time_white_24dp,
                    R.drawable.ic_access_time_white_24dp,
                    R.drawable.ic_access_time_white_24dp};

    ArrayList<HashMap<String, String>> data=new ArrayList<HashMap<String,String>>();
    SimpleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub

        //MAP
        HashMap<String, String> map=new HashMap<String, String>();

        //FILL
        for(int i=0;i<players.length;i++)
        {
            map=new HashMap<String, String>();
            map.put("Player", players[i]);
            map.put("Image", Integer.toString(images[i]));

            data.add(map);
        }

        //KEYS IN MAP
        String[] from={"Player","Image"};

        //IDS OF VIEWS
        int[] to={R.id.nameTxt,R.id.imageView};

        //ADAPTER
        adapter=new SimpleAdapter(getActivity(), data, R.layout.movie_list_row, from, to);
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> av, View v, int pos,
                                    long id) {
                // TODO Auto-generated method stub

                Toast.makeText(getActivity(), data.get(pos).get("Player"), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
