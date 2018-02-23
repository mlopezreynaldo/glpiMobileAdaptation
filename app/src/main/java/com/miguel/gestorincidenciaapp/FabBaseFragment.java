package com.miguel.gestorincidenciaapp;

import android.app.Fragment;

import com.hlab.fabrevealmenu.view.FABRevealMenu;

public class FabBaseFragment extends Fragment{

    private FABRevealMenu fabRevealMenu;

    public boolean onBackPRessed(){

        if(fabRevealMenu != null){

            if(fabRevealMenu.isShowing()){
                fabRevealMenu.closeMenu();
                return false;
            }

        }
        return true;
    }

    public FABRevealMenu getFabRevealMenu(){
        return fabRevealMenu;
    }

    public void setFabRevealMenu(FABRevealMenu fabRevealMenu){
        this.fabRevealMenu = fabRevealMenu;
    }

}
