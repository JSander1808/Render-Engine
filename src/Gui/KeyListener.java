package Gui;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_A){
            Viewport.camObj.getGlobalPosition().setY(Viewport.camObj.getGlobalPosition().getY()+1);
        }
        if(e.getKeyCode()==KeyEvent.VK_W){
            Viewport.camObj.getGlobalPosition().setX(Viewport.camObj.getGlobalPosition().getX()-1);
        }
        if(e.getKeyCode()==KeyEvent.VK_S){
            Viewport.camObj.getGlobalPosition().setX(Viewport.camObj.getGlobalPosition().getX()+1);
        }
        if(e.getKeyCode()==KeyEvent.VK_D){
            Viewport.camObj.getGlobalPosition().setY(Viewport.camObj.getGlobalPosition().getY()-1);
        }
        if(e.getKeyCode()==KeyEvent.VK_R){
            Viewport.camObj.getGlobalPosition().setZ(Viewport.camObj.getGlobalPosition().getZ()+1);
        }
        if(e.getKeyCode()==KeyEvent.VK_F){
            Viewport.camObj.getGlobalPosition().setZ(Viewport.camObj.getGlobalPosition().getZ()-1);
        }


        if(e.getKeyCode()==KeyEvent.VK_NUMPAD1){
            Viewport.camObj.setYaw(Viewport.camObj.getYaw()-1);
        }
        if(e.getKeyCode()==KeyEvent.VK_NUMPAD4){
            Viewport.camObj.setYaw(Viewport.camObj.getYaw()+1);
        }
        if(e.getKeyCode()==KeyEvent.VK_NUMPAD2){
            Viewport.camObj.setPitch(Viewport.camObj.getPitch()-1);
        }
        if(e.getKeyCode()==KeyEvent.VK_NUMPAD5){
            Viewport.camObj.setPitch(Viewport.camObj.getPitch()+1);
        }
        if(e.getKeyCode()==KeyEvent.VK_NUMPAD3){
            Viewport.camObj.setRoll(Viewport.camObj.getRoll()-1);
        }
        if(e.getKeyCode()==KeyEvent.VK_NUMPAD6){
            Viewport.camObj.setRoll(Viewport.camObj.getRoll()+1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
