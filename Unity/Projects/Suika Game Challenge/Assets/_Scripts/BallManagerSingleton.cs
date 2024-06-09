using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BallManagerSingleton : MonoBehaviour
{
    public static BallManagerSingleton Instance;

    public List<GameObject> activeBalls = new List<GameObject>();

    void Awake()
    {
        if (Instance == null)
        {
            Instance = this;
        }
        else
        {
            Destroy(gameObject);
        }
    }

    public void RegisterBasketball(GameObject basketball)
    {
        activeBalls.Add(basketball);
    }

    public void UnregisterBasketball(GameObject basketball)
    {
        activeBalls.Remove(basketball);
    }

    public int GetActiveBasketballCount()
    {
        return activeBalls.Count;
    }
}
