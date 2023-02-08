package com.binus.projekuasmobileprog;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.binus.projekuasmobileprog.Adapter.AdapterData;
import com.binus.projekuasmobileprog.Model.DataFilm;
import com.binus.projekuasmobileprog.Model.Response;
import com.binus.projekuasmobileprog.Model.Search;
import com.binus.projekuasmobileprog.Rest.ApiClient;
import com.binus.projekuasmobileprog.Rest.ApiInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FilmFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilmFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private AdapterData adapterData;
    String API_KEY = "42b59644";
    String S = "avengers";
    RecyclerView recyclerViewFilm;

    public FilmFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FilmFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FilmFragment newInstance(String param1, String param2) {
        FilmFragment fragment = new FilmFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_film, container, false);

        recyclerViewFilm = view.findViewById(R.id.recyclerViewFilm);
        recyclerViewFilm.setHasFixedSize(true);
        recyclerViewFilm.setLayoutManager(new LinearLayoutManager(getContext()));

        callRetrofit();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private void callRetrofit() {

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<Response> call = apiInterface.getFilm(S, API_KEY);

        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                List<Search> searchList = response.body().getSearch();
                adapterData = new AdapterData(getContext(), searchList);
                recyclerViewFilm.setAdapter(adapterData);
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });
    }

//    private void getData() {
//
//        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
//
//        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//
//                listFilm = new ArrayList<DataFilm>();
//
//                try {
//                    JSONArray jsonArray = response.getJSONArray("Search");
//
//                    for (int i = 0; i < jsonArray.length(); i++) {
//
//                        JSONObject data = jsonArray.getJSONObject(i);
//
//                        dataFilm = new DataFilm();
//
//                        Log.d("isi", data.getString("Title"));
//                        Log.d("isi", data.getString("Poster"));
//
//                        dataFilm.setNamaFilm(data.getString("Title"));
//                        dataFilm.setGambarFilm(data.getString("Poster"));
//
//                        listFilm.add(dataFilm);
//                    }
//
//                    linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,
//                            false);
//
//                    recyclerViewFilm.setLayoutManager(linearLayoutManager);
//
//                    adapterData = new AdapterData(getContext(), listFilm);
//                    recyclerViewFilm.setAdapter(adapterData);
//                    adapterData.notifyDataSetChanged();
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//
//        requestQueue.add(request);
//    }

//    private void getData() {
//
//        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//                listFilm = new ArrayList<DataFilm>();
//
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    JSONArray jsonArray = jsonObject.getJSONArray("Search");
//
//                    for (int i = 0; i < jsonArray.length(); i++) {
//
//                        JSONObject data = jsonArray.getJSONObject(i);
//
//                        dataFilm = new DataFilm();
//                        dataFilm.setNamaFilm(data.getString("Title"));
//                        dataFilm.setGambarFilm(data.getString("Poster"));
//
//                        listFilm.add(dataFilm);
//                    }
//
//                    linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,
//                            false);
//
//                    recyclerViewFilm.setLayoutManager(linearLayoutManager);
//
//                    adapterData = new AdapterData(getContext(), listFilm);
//                    recyclerViewFilm.setAdapter(adapterData);
//                    adapterData.notifyDataSetChanged();
//
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//
//        requestQueue.add(stringRequest);
//    }
}