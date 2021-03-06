package it.test.listview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class TestListViewActivity extends Activity {
	
	private List<String> dataSource;
	private ArrayAdapter<String> adapter;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        dataSource = createFakeDatasource();
        
        adapter = new MyAdapter(this,dataSource);
        
        ListView listView = (ListView)this.findViewById(R.id.mylistview);
        listView.setAdapter(adapter);
    }
    
    private List<String> createFakeDatasource(){
    	ArrayList<String> list = new ArrayList<String>();
    	list.add("Test1");
    	list.add("Test2");
    	list.add("Test3");
    	return list;
    }
    
    private class MyAdapter extends ArrayAdapter<String>{
    	private Context context;
    	
    	public MyAdapter(Context context, List<String> data){
    		super(context, R.layout.cell, R.id.cell_title, data);
    		this.context = context;
    	}
    	
    	public View getView (int position, View convertView, ViewGroup parent){
    		LinearLayout layout;
    		if(convertView == null){
    			LayoutInflater inflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
    			layout = (LinearLayout)inflater.inflate(R.layout.cell, null);
    		}
    		else{
    			layout = (LinearLayout)convertView;
    		}
    		
    		((TextView)layout.findViewById(R.id.cell_title)).setText(dataSource.get(position));
    		
    		return layout;
    	}
    	
    }
}