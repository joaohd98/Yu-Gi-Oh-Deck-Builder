package com.deck.yugioh.HttpRequest;

import androidx.annotation.NonNull;

import com.deck.yugioh.HttpRequest.Utils.Request;
import com.deck.yugioh.HttpRequest.Utils.RequestCallBack;
import com.deck.yugioh.Model.ForgotPassword.ForgotPasswordRequest;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordAPI implements Request<ForgotPasswordRequest> {

    public void callRequest(final ForgotPasswordRequest request, final RequestCallBack callBack) {

        final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.sendPasswordResetEmail(request.getEmail()).addOnCompleteListener(new OnCompleteListener<Void>() {

            @Override
            public void onComplete(@NonNull Task task) {

                if(task.isSuccessful())
                    callBack.success();

                else
                    callBack.error(task.getException());

            }

        });
    }

}
