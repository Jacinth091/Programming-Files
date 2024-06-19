using System.Collections;
using System.Collections.Generic;
using Unity.VisualScripting;
using UnityEngine;
using UnityEngine.Audio;
using UnityEngine.UI;

public class SoundMixerManager : MonoBehaviour
{
    [SerializeField] private AudioMixer audioMixer;
    [SerializeField] private Slider masterSlider;
    [SerializeField] private Slider musicSlider;
    [SerializeField] private Slider sfxSlider;


    private void Start()
    {
        if (PlayerPrefs.HasKey("masterVolumeData"))
        {
            LoadVolume();
            Debug.Log("LoadVolume!!");
        }
        else
        {
            SetMasterVolume();
            SetSoundFXVolume();
            SetMusicVolume();
        }
    }


    public void SetMasterVolume()
    {
        float level = masterSlider.value;
        //audioMixer.SetFloat("masterVolume", level);
        audioMixer.SetFloat("masterVolume", Mathf.Log10(level) * 20f);
        PlayerPrefs.SetFloat("masterVolumeData", level);
    }

    public void SetSoundFXVolume()
    {

        float level = sfxSlider.value;
        //audioMixer.SetFloat("soundFXVolume", level);
        audioMixer.SetFloat("soundFXVolume", Mathf.Log10(level) * 20f);
        PlayerPrefs.SetFloat("sfxVolumeData", level);


    }

    public void SetMusicVolume()
    {
        float level = musicSlider.value;

        //audioMixer.SetFloat("musicVolume", level);
        audioMixer.SetFloat("musicVolume", Mathf.Log10(level) * 20f);
        PlayerPrefs.SetFloat("musicVolumeData", level);



    }


    public void LoadVolume()
    {
        masterSlider.value = PlayerPrefs.GetFloat("masterVolumeData");
        musicSlider.value = PlayerPrefs.GetFloat("musicVolumeData");
        sfxSlider.value = PlayerPrefs.GetFloat("sfxVolumeData");
        SetMasterVolume();
        SetSoundFXVolume();
        SetMusicVolume();
    }


}
