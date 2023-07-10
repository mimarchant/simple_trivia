package com.example.simple_trivia;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.simple_trivia.databinding.FragmentAnswerBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnswerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnswerFragment extends Fragment {
    FragmentAnswerBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnswerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnswerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnswerFragment newInstance(String param1, String param2) {
        AnswerFragment fragment = new AnswerFragment();
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
        binding = FragmentAnswerBinding.inflate(getLayoutInflater());
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            Boolean isCorrect = bundle.getBoolean("isCorrect");
            if (isCorrect) {
                binding.tvAnswer.setText("has acertado! Felicitaciones");
            } else {
                binding.tvAnswer.setText("respuesta incorrecta, intenta nuevamente :)");
            }

        }

        binding.returnHomeBtn.setOnClickListener(v -> {
            Navigation.findNavController(getView()).navigate(R.id.action_answerFragment_to_questionFragment);
        });

        return binding.getRoot();
    }
}