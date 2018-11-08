package project.miage.geomeetingv2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static Uri CONTENT_URI = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
    private static String NAME = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;
    private static String NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;
    private ArrayList<Contact> contactsList;
    private MyAdapter adapter;
    private String DateRdv;
    List<String> intitals = new ArrayList<>();
    DatePickerDialog datePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MyAdapter(this, loadContacts());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.contactListView);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        ///////////Button demander



    }

    public void sendRequest(View view){
        Intent intent = new Intent(this, send_request.class);
        intent.putParcelableArrayListExtra("destinataires", adapter.getCheckedContacts());
        //intent.putExtra("destinataires", adapter.getCheckedContacts());
        startActivity(intent);
    }
    public void requestListener(View view){
        final Calendar calendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                String Daterdv = DateFormat.getDateInstance(DateFormat.MEDIUM).format(calendar.getTime());
                Log.d("MainActivity", "Selected date is " + Daterdv);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
    public ArrayList<Contact> loadContacts() {

        Cursor phones;
        phones = getContentResolver().query(CONTENT_URI, new String[]{NAME, NUMBER},null,null, null);
        Set<Contact> Contacts = new HashSet<>();

        while (phones.moveToNext())
        {
            String name=phones.getString(phones.getColumnIndex(NAME));
            String phoneNumber = phones.getString(phones.getColumnIndex(NUMBER));

            Contacts.add(new Contact(name,phoneNumber));
            intitals.add(name.charAt(0)+""+name.charAt(1));

        }
        Log.i("","List size ="+Contacts.size());
        contactsList = new ArrayList<Contact>(Contacts);

        Collections.sort(contactsList, new CustomComparator());
        phones.close();
        return contactsList;
    }

    public class CustomComparator implements Comparator<Contact> {
        @Override
        public int compare(Contact o1, Contact o2) {
            return o1.getNom().compareTo(o2.getNom());
        }
    }


}
