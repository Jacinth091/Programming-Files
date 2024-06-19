using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;
using System.Threading.Tasks;

public class GameManager : MonoBehaviour
{
    public static GameManager instance;
    public GameObject loadingScreen;
    public Slider progressBar;

    private void Awake()
    {
        if (instance == null)
        {
            instance = this;
            DontDestroyOnLoad(gameObject);

            // Ensure the loadingScreen is not destroyed during scene transitions
            if (loadingScreen != null)
            {
                DontDestroyOnLoad(loadingScreen);
            }

            SceneManager.LoadSceneAsync((int)SceneIndex.MAIN_MENU, LoadSceneMode.Additive);
        }
        else if (instance != this)
        {
            Destroy(gameObject);
        }

    }

    List<AsyncOperation> scenesLoading = new List<AsyncOperation>();
    private float totalSceneProgress;
    private float displayProgress;
    public float progressSpeed = 1f;
    public void LoadGame()
    {

        if (progressBar == null)
        {
            Debug.LogError("Progress bar is not assigned!");
            return;
        }

        loadingScreen.gameObject.SetActive(true);
        scenesLoading.Add(SceneManager.UnloadSceneAsync((int)SceneIndex.MAIN_MENU));
        scenesLoading.Add(SceneManager.LoadSceneAsync((int)SceneIndex.GAME_lEVEL));
        //SceneManager.LoadSceneAsync((int)SceneIndex.MAIN_MENU);
        //scenesLoading[1].allowSceneActivation = false;

        StartCoroutine(GetSceneProgress());


    }

    public void LoadMenu()
    {

        if (progressBar == null)
        {
            Debug.LogError("Progress bar is not assigned!");
            return;
        }

        loadingScreen.gameObject.SetActive(true);
        scenesLoading.Add(SceneManager.UnloadSceneAsync((int)SceneIndex.GAME_lEVEL));
        scenesLoading.Add(SceneManager.LoadSceneAsync((int)SceneIndex.MAIN_MENU));
        //scenesLoading[1].allowSceneActivation = false;

        StartCoroutine(GetSceneProgress());



    }

    private IEnumerator GetSceneProgress()
    {
        // Initialize display progress
        displayProgress = 0f;

        for (int i = 0; i < scenesLoading.Count; i++)
        {
            while (!scenesLoading[i].isDone)
            {
                totalSceneProgress = 0f;
                foreach (AsyncOperation operation in scenesLoading)
                {
                    if (operation == null)
                    {
                        Debug.LogError("Operation is null!");
                        continue;
                    }
                    totalSceneProgress += operation.progress;

                }

                totalSceneProgress = (totalSceneProgress / scenesLoading.Count) * 100f;

                // Gradually increase the display progress to the actual progress
                while (displayProgress < totalSceneProgress)
                {
                    displayProgress += progressSpeed;
                    progressBar.value = Mathf.Clamp01(displayProgress / 100f);
                    yield return new WaitForSeconds(0.02f); // Small delay to slow down the progress bar
                }

                yield return null;
            }
        }

        // Ensure the progress bar is full at the end
        progressBar.value = 1f;
        scenesLoading[1].allowSceneActivation = true;
        loadingScreen.gameObject.SetActive(false);
    }
}















/*using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;
//using UnityEngine.UIElements;

public class GameManager : MonoBehaviour
{
    public static GameManager instance;
    public GameObject loadingScreen;
    public Slider progressBar;

    private void Awake()
    {
        if (instance == null)
        {
            instance = this;
            DontDestroyOnLoad(gameObject);

            // Ensure the loadingScreen is not destroyed during scene transitions
            if (loadingScreen != null)
            {
                DontDestroyOnLoad(loadingScreen);
            }

            SceneManager.LoadSceneAsync("MainMenu", LoadSceneMode.Additive);
        }
        else if (instance != this)
        {
            Destroy(gameObject);
        }
    }

    List<AsyncOperation> scenesLoading = new List<AsyncOperation>();
    private float totalSceneProgress;
    private float displayProgress;
    public float progressSpeed = 1f;


    public void LoadGame(string sceneToUnload, string sceneToLoad)
    {
        // load main level
        StartCoroutine(LoadScenes(sceneToUnload, sceneToLoad));
    }

    public void LoadMenu(string sceneToUnload, string sceneToLoad)
    {
        // load main menu
        StartCoroutine(LoadScenes(sceneToUnload, sceneToLoad));
    }

    public void RestartScene(string sceneToUnload, string sceneToLoad)
    {
        StartCoroutine(LoadScenes(sceneToUnload, sceneToLoad));
    }

    private IEnumerator LoadScenes(string sceneToUnload, string sceneToLoad)
    {
        bool isLoadingComplete = false;
        loadingScreen.gameObject.SetActive(true);
        scenesLoading.Clear();



        // Start unloading and loading scenes asynchronously
        scenesLoading.Add(SceneManager.UnloadSceneAsync(sceneToUnload));
        scenesLoading.Add(SceneManager.LoadSceneAsync(sceneToLoad));
        //scenesLoading[1].allowSceneActivation = false;
        //loadOperation.allowSceneActivation = false; // Prevent the scene from activating immediately
        //scenesLoading.Add(loadOperation);

        displayProgress = 0f;
        for (int i = 0; i < scenesLoading.Count; i++)
        {
            while (!scenesLoading[i].isDone)
            {
                totalSceneProgress = 0f;

                // Calculate the total progress of both loading operations
                foreach (AsyncOperation operation in scenesLoading)
                {
                    totalSceneProgress += operation.progress;
                }

                totalSceneProgress = (totalSceneProgress / scenesLoading.Count) * 100f;

                // Gradually increase the display progress to the actual progress
                while (displayProgress < totalSceneProgress)
                {
                    displayProgress += progressSpeed;
                    progressBar.value = Mathf.Clamp01(displayProgress / 100f);
                    yield return new WaitForSeconds(0.02f);// Small delay to slow down the progress bar

                }
                yield return null;
            }
        }

        Debug.Log(isLoadingComplete);
        // Ensure the progress bar is full at the end
        progressBar.value = 1f;

        // Allow the scene to activate
        scenesLoading[1].allowSceneActivation = true;
        Debug.Log(scenesLoading[1].allowSceneActivation);


        loadingScreen.gameObject.SetActive(false);
    }


}*/


/* private IEnumerator RestartCurrentScene()
 {
     int currentSceneIndex = SceneManager.GetActiveScene().buildIndex;
     loadingScreen.gameObject.SetActive(true);

     scenesLoading.Clear();
     scenesLoading.Add(SceneManager.UnloadSceneAsync(currentSceneIndex));
     AsyncOperation loadOperation = SceneManager.LoadSceneAsync(currentSceneIndex);
     loadOperation.allowSceneActivation = false; // Prevent the scene from activating immediately
     scenesLoading.Add(loadOperation);

     //scenesLoading[1].allowSceneActivation = false;
     //loadOperation.allowSceneActivation = false; // Prevent the scene from activating immediately
     //scenesLoading.Add(loadOperation);

     displayProgress = 0f;
     for (int i = 0; i < scenesLoading.Count; i++)
     {
         while (!scenesLoading[i].isDone)
         {
             totalSceneProgress = 0f;

             // Calculate the total progress of both loading operations
             foreach (AsyncOperation operation in scenesLoading)
             {
                 totalSceneProgress += operation.progress;
             }

             totalSceneProgress = (totalSceneProgress / scenesLoading.Count) * 100f;

             // Gradually increase the display progress to the actual progress
             while (displayProgress < totalSceneProgress)
             {
                 displayProgress += progressSpeed;
                 progressBar.value = Mathf.Clamp01(displayProgress / 100f);
                 yield return new WaitForSeconds(0.02f);// Small delay to slow down the progress bar

             }
             yield return null;
         }
     }

     Debug.Log(isLoadingComplete);
     // Ensure the progress bar is full at the end
     progressBar.value = 1f;

     // Allow the scene to activate
     scenesLoading[1].allowSceneActivation = true;
     Debug.Log(scenesLoading[1].allowSceneActivation);


     loadingScreen.gameObject.SetActive(false);
 }*/





/*using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;
using System.Threading.Tasks;

public class GameManager : MonoBehaviour
{
    public static GameManager instance;
    public GameObject loadingScreen;
    public Slider progressBar;

    private void Awake()
    {
        if (instance == null)
        {
            instance = this;
            DontDestroyOnLoad(gameObject);
            if (loadingScreen != null)
            {
                DontDestroyOnLoad(loadingScreen);
            }
            SceneManager.LoadSceneAsync((int)SceneIndex.MAIN_MENU, LoadSceneMode.Additive);
        }
        else if (instance != this)
        {
            Destroy(gameObject);
        }
    }

    List<AsyncOperation> scenesLoading = new List<AsyncOperation>();
    private float totalSceneProgress;
    private float displayProgress;
    public float progressSpeed = 1f;


    public void LoadGame(int sceneToUnload, int sceneToLoad)
    {
        // load main level
        StartCoroutine(LoadScenes(sceneToUnload, sceneToLoad));
    }

    public void LoadMenu(int sceneToUnload, int sceneToLoad)
    {
        // load main menu
        StartCoroutine(LoadScenes(sceneToUnload, sceneToLoad));

    }


    private IEnumerator LoadScenes(int sceneToUnload, int sceneToLoad)
    {
        loadingScreen.gameObject.SetActive(true);
        scenesLoading.Clear();

        // Start unloading and loading scenes asynchronously
        scenesLoading.Add(SceneManager.UnloadSceneAsync(sceneToUnload));
        scenesLoading.Add(SceneManager.LoadSceneAsync(sceneToLoad));

        displayProgress = 0f;

        bool loadingComplete = false;

        while (!loadingComplete)
        {
            totalSceneProgress = 0f;
            loadingComplete = true;

            // Calculate the total progress of both loading operations
            foreach (AsyncOperation operation in scenesLoading)
            {
                totalSceneProgress += operation.progress;

                // If any of the operations are not yet done, set loadingComplete to false
                if (!operation.isDone)
                {
                    loadingComplete = false;
                }
            }

            totalSceneProgress = (totalSceneProgress / scenesLoading.Count) * 100f;

            // Gradually increase the display progress to the actual progress
            while (displayProgress < totalSceneProgress)
            {
                displayProgress += progressSpeed;
                progressBar.value = Mathf.Clamp01(displayProgress / 100f);
                yield return new WaitForSeconds(0.02f); // Small delay to slow down the progress bar
            }

            yield return null;
        }

        // Ensure the progress bar is full at the end
        progressBar.value = 1f;
        loadingScreen.gameObject.SetActive(false);
    }
    public void RestartScene()
    {
        StartCoroutine(RestartCurrentScene());
    }

    private IEnumerator RestartCurrentScene()
    {
        int currentSceneIndex = SceneManager.GetActiveScene().buildIndex;
        loadingScreen.gameObject.SetActive(true);

        scenesLoading.Clear();
        scenesLoading.Add(SceneManager.UnloadSceneAsync(currentSceneIndex));
        scenesLoading.Add(SceneManager.LoadSceneAsync(currentSceneIndex));

        displayProgress = 0f;

        for (int i = 0; i < scenesLoading.Count; i++)
        {
            while (!scenesLoading[i].isDone)
            {
                totalSceneProgress = 0f;
                foreach (AsyncOperation operation in scenesLoading)
                {
                    totalSceneProgress += operation.progress;
                }

                totalSceneProgress = (totalSceneProgress / scenesLoading.Count) * 100f;

                while (displayProgress < totalSceneProgress)
                {
                    displayProgress += progressSpeed;
                    progressBar.value = Mathf.Clamp01(displayProgress / 100f);
                    yield return new WaitForSeconds(0.02f);
                }

                yield return null;
            }
        }

        progressBar.value = 1f;
        loadingScreen.gameObject.SetActive(false);
    }
}*/
/*public void LoadGame()
{
    loadingScreen.gameObject.SetActive(true);
    scenesLoading.Add(SceneManager.UnloadSceneAsync((int)SceneIndex.MAIN_MENU));
    scenesLoading.Add(SceneManager.LoadSceneAsync((int)SceneIndex.GAME_lEVEL));
    //SceneManager.LoadSceneAsync((int)SceneIndex.MAIN_MENU);
    StartCoroutine(GetSceneProgress());

}


private IEnumerator GetSceneProgress()
{
    // Initialize display progress
    displayProgress = 0f;

    for (int i = 0; i < scenesLoading.Count; i++)
    {
        while (!scenesLoading[i].isDone)
        {
            totalSceneProgress = 0f;
            foreach (AsyncOperation operation in scenesLoading)
            {
                totalSceneProgress += operation.progress;
            }

            totalSceneProgress = (totalSceneProgress / scenesLoading.Count) * 100f;

            // Gradually increase the display progress to the actual progress
            while (displayProgress < totalSceneProgress)
            {
                displayProgress += progressSpeed;
                progressBar.value = Mathf.Clamp01(displayProgress / 100f);
                yield return new WaitForSeconds(0.02f); // Small delay to slow down the progress bar
            }

            yield return null;
        }
    }

    // Ensure the progress bar is full at the end
    progressBar.value = 1f;
    loadingScreen.gameObject.SetActive(false);
}*/







/*using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;
using System.Threading.Tasks;

public class ASyncLoader : MonoBehaviour
{
    public static ASyncLoader Instance { get; private set; }

    [Header("Scenes")]
    [SerializeField] private GameObject loadingScreen;

    [Header("Slider")]
    [SerializeField] private  Slider progressBar;

    //private AsyncOperation loadOperation;

    private void Awake()
    {
        Debug.Log("ASyncLoader Awake called");
        if (Instance == null)
        {
            Instance = this;
            DontDestroyOnLoad(gameObject);
        }
        else
        {
            Destroy(gameObject);
        }
    }

    public async void LoadScene(int sceneName)
    {
        DeactivateCurrentScene();

        float progressVal = 0f;
        AsyncOperation loadOperation = SceneManager.LoadSceneAsync(sceneName);

        loadOperation.allowSceneActivation = false;
        loadingScreen.SetActive(true);

        Debug.Log("Hellow!");
        do
        {

            await Task.Delay(100);
            progressVal = Mathf.Clamp01(loadOperation.progress / 0.9f);
            progressBar.value = loadOperation.progress;

        } while (progressVal < 0.9f);

        DeactivateCurrentScene();
        await Task.Delay(2000);

        //StartCoroutine(loadLevelASync(sceneName));

        loadOperation.allowSceneActivation = true;
        loadingScreen.SetActive(false);

    }
    private void DeactivateCurrentScene()
    {
        Scene currentScene = SceneManager.GetActiveScene();
        SceneManager.UnloadSceneAsync(currentScene);

        //GameObject[] rootObjects = currentScene.GetRootGameObjects();
        //foreach (GameObject obj in rootObjects)
        //{
        //    obj.SetActive(false);
        //}
    }
}*/
//IEnumerator loadLevelASync(string sceneName) {

//    while (!loadOperation.isDone)
//    {
//        float progressVal = Mathf.Clamp01(loadOperation.progress / 0.9f);
//        progressBar.value = progressVal;
//        yield return null;
//    }
//    yield return new WaitForSeconds(100f);


//}
/*
    public void LoadScene(string sceneToLoad)
    {   

        StartCoroutine(LoadLevelASync(sceneToLoad));
    }

    private IEnumerator LoadLevelASync(string sceneToLoad)
    {
        // Load the target scene asynchronously and additively
        AsyncOperation loadOperation = SceneManager.LoadSceneAsync(sceneToLoad);

        loadOperation.allowSceneActivation = false;

        loadingScreen.SetActive(true);
        while (!loadOperation.isDone)
        {
            float progressVal = Mathf.Clamp01(loadOperation.progress / 0.9f);
            progressBar.value = progressVal;
            yield return null;
        }
        loadOperation.allowSceneActivation = true;

        // Unload the main menu scene
        string currentSceneName = SceneManager.GetActiveScene().name;
        SceneManager.UnloadSceneAsync(currentSceneName);

        // Optionally, you could set the loading screen to inactive once the new scene is loaded
        loadingScreen.SetActive(false);
    }
*/
//private void Start()
//{
//    // Load MainMenu scene additively when the game starts
//    SceneManager.LoadSceneAsync("MainMenu", LoadSceneMode.Additive);
//}

