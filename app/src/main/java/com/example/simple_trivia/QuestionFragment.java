package com.example.simple_trivia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.simple_trivia.databinding.FragmentQuestionBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment {
    private FragmentQuestionBinding binding;
    private String answer = "kny";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public QuestionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionFragment newInstance(String param1, String param2) {
        QuestionFragment fragment = new QuestionFragment();
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
        binding = FragmentQuestionBinding.inflate(getLayoutInflater());
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String name = bundle.getString("name", "");
            String greeting = "Hola, " + name;
            binding.textViewName.setText(greeting);
        }

        binding.continueBtn.setOnClickListener(v -> {
            int selectedId = binding.radioGroup.getCheckedRadioButtonId();
            Bundle answer = new Bundle();

            if (selectedId == -1) {
                Toast.makeText(getContext(), "Debes seleccionar una opción", Toast.LENGTH_SHORT).show();
            } else answer.putBoolean("isCorrect", selectedId == R.id.kny);

            Navigation.findNavController(getView()).navigate(R.id.action_questionFragment_to_answerFragment, answer);

        });





        return binding.getRoot();
    }
}