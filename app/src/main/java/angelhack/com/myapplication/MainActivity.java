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
import android.widget.RelativeLayout;

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

    RelativeLayout rlActivity;

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

        rlActivity = (RelativeLayout) findViewById(R.id.rlActivity);
        rlActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NotificationActivity.class);
                startActivity(intent);
            }
        });


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        employees = new ArrayList<>();
        employees.add(new Employee(R.drawable.profile_jimmylee, "Jimmy Lee", 120, 22, "250m"));
        employees.add(new Employee(R.drawable.profile_stevo, "Stevo Leung", 89, 79, "260m"));
        employees.add(new Employee(R.drawable.profile_victor, "Victor Li", 110, 99, "500m"));
        employees.add(new Employee(R.drawable.profile_jimmy, "Raymond Kwok", 200, 230, "800m"));
        employees.add(new Employee(R.drawable.profile_tony, "Tony Jaa", 150, 232, "1 km"));
        employees.add(new Employee(R.drawable.profile_leon, "Leon Maverick", 164, 375, "100km"));

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

//        employees.clear();
//        employees.add(new Employee(R.drawable.profile_eugene, "Gene", 120, 10));
//        employees.add(new Employee(R.drawable.profile_jimmy, "Jimmy", 120, 110));
//        employees.add(new Employee(R.drawable.profile_stevo, "Stevo", 20, 210));
//        employees.add(new Employee(R.drawable.profile_victor, "Victor", 20, 10));
//
//        nearbyPeopleAdapter.notifyDataSetChanged();

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.i(TAG, "onQueryTextChange: " + newText);

//        employees.clear();
//        employees.add(new Employee(R.drawable.profile_stevo, "Stevo", 20, 210));
//        employees.add(new Employee(R.drawable.profile_victor, "Victor", 20, 10));
//
//        nearbyPeopleAdapter.notifyDataSetChanged();

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
        LatLng here = new LatLng(22.309784, 114.224533);
        mMap.addMarker(new MarkerOptions().position(here).title("Jimmy Lee"));

        LatLng here2 = new LatLng(22.311762, 114.223838);
        mMap.addMarker(new MarkerOptions().position(here2).title("Stevo Leung"));

        LatLng here3 = new LatLng(22.310085, 114.222926);
        mMap.addMarker(new MarkerOptions().position(here3).title("Victor Li"));

        LatLng here4 = new LatLng(22.312651, 114.222577);
        mMap.addMarker(new MarkerOptions().position(here4).title("Raymond Kwok"));

        LatLng here5 = new LatLng(22.307386, 114.227947);
        mMap.addMarker(new MarkerOptions().position(here5).title("Tony Jaa"));

        LatLng here6 = new LatLng(22.395246, 114.218783 );
        mMap.addMarker(new MarkerOptions().position(here6).title("Leon Maverick"));

//        mMap.moveCamera(CameraUpdateFactory.newLatLng(here));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(here.latitude, here.longitude), 13.0f));


    }
}
