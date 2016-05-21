package angelhack.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import angelhack.com.model.Employee;

public class MainActivity extends AppCompatActivity
        implements SearchView.OnQueryTextListener, OnMapReadyCallback {
    private static final String TAG = "MainActivity";

    GoogleMap mMap;

    ListView listView;

    List<Employee> employees;

    NearbyPeopleAdapter nearbyPeopleAdapter;

    public static final String SEARCH_KEYWORD = "SEARCH_KEYWORD";
    public String searchKeyword = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            searchKeyword = bundle.getString(SEARCH_KEYWORD);
        }

        listView = (ListView) findViewById(R.id.lvNearby);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        employees = new ArrayList<>();
        employees.add(new Employee(R.drawable.profile_eugene, "Gene", 120, 10));
        employees.add(new Employee(R.drawable.profile_jimmy, "Jimmy", 120, 110));
        employees.add(new Employee(R.drawable.profile_stevo, "Stevo", 20, 210));
        employees.add(new Employee(R.drawable.profile_victor, "Victor", 20, 10));


        nearbyPeopleAdapter = new NearbyPeopleAdapter(MainActivity.this, employees);

        listView.setAdapter(nearbyPeopleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onItemClick: " + position);

                Intent intent = new Intent(MainActivity.this, EmployeeProfileActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(this);
        searchView.setQuery(searchKeyword, true);

        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.i(TAG, "onQueryTextSubmit: " + query);

        employees.add(new Employee(R.drawable.profile_eugene, "Gene", 120, 10));
        employees.add(new Employee(R.drawable.profile_jimmy, "Jimmy", 120, 110));
        employees.add(new Employee(R.drawable.profile_stevo, "Stevo", 20, 210));
        employees.add(new Employee(R.drawable.profile_victor, "Victor", 20, 10));

        nearbyPeopleAdapter.notifyDataSetChanged();

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.i(TAG, "onQueryTextChange: " + newText);

        employees.add(new Employee(R.drawable.profile_stevo, "Stevo", 20, 210));
        employees.add(new Employee(R.drawable.profile_victor, "Victor", 20, 10));

        nearbyPeopleAdapter.notifyDataSetChanged();

        return false;
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-22, 114);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
