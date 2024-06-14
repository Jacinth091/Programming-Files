using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public static class GlobalReference
{
    private static GameObject mainMenuScene;

    private static GameObject mainMenuSceneData
    {
        get {

            if (mainMenuScene) return mainMenuScene;


            mainMenuScene = GameObject.FindGameObjectWithTag("MainMenu").GetComponent<GameObject>();

            return mainMenuScene;
        }
        set { mainMenuScene = value;


            OnStartPanelReady?.Invoke(null);
        
        
        }

    }

    public static event Action<GameObject> OnStartPanelReady;
}
