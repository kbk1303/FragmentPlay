package zbc.dk.krik.fragmentplay;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NotifierFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotifierFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private EditText multiLine;
    private ValueNotifier valueNotifier;

    private NotifierFragment() {
        // Required empty private constructor, due to singleton pattern
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment NotifierFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NotifierFragment newInstance(String param1) {
        NotifierFragment fragment = new NotifierFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            valueNotifier = (ValueNotifier) context;
            valueNotifier.setValue("Hello from NotifierFragment");
        } catch (ClassCastException csException) {
            throw new ClassCastException(context.toString() +" must implement ValueNotifier");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_notifier, container, false);
        multiLine = (EditText) view.findViewById(R.id.editTextMultiLineFragment);
        multiLine.append("Activity sent: "+ mParam1 + '\n');
        return view;
    }
}