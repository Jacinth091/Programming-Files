using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class SpriteScaler : MonoBehaviour
{
    [SerializeField] private SpriteRenderer spriteRenderer;
    [SerializeField] private Transform ballObj;
    [SerializeField] private CircleCollider2D ballCollider;
    [SerializeField] private Rigidbody2D rb;
    private float sizeMult = 2f;
    [SerializeField] private float constantSpeed = 0.1f;

    void Start()
    {
        rb = gameObject.GetComponent<Rigidbody2D>();
        //float scaleFactor = 0f;
        if (ballObj != null && ballCollider != null && sizeMult < 0f)
        {
            // Ensure the initial scale is 1,1,1
            ballObj.transform.localScale = Vector3.up;

            // Get the collider radius
            float colliderRadius = ballCollider.radius;
            Debug.Log("Collider Radius: " + colliderRadius);

            // Get the actual size of the sprite in world units
            spriteRenderer = ballObj.gameObject.GetComponent<SpriteRenderer>();
            if (spriteRenderer == null)
            {
                Debug.LogError("SpriteRenderer component is missing!");
                return;
            }
            float spriteWidth = spriteRenderer.bounds.size.x;
            //Debug.Log("Sprite Width: " + spriteWidth);

            // Calculate the scale factor
            
            float scaleFactor = (colliderRadius * sizeMult) / spriteWidth;
            //float scaleFactor = (colliderRadius * 10f);

            //Debug.Log("Scale Factor: " + scaleFactor);

            // Apply the scale factor uniformly to maintain aspect ratio
            Vector3 newScale = new Vector3(scaleFactor, scaleFactor, 1f);
            ballObj.transform.localScale = newScale;
            //Debug.Log("New Scale: " + newScale);

        }
        //else
        //{
        //    Debug.LogError("Transform or Collider reference is missing!");
        //}

        //if (rb.velocity.y == 0)
        //{
        //    float rollVelocity = 0.5f;
        //    rb.AddForce(new Vector2(rollVelocity, 0f));
        //}

    }
    void FixedUpdate()
    {
        //if (Mathf.Abs(rb.velocity.y) < 0.1f) // Check if the ball is on the surface (no significant vertical velocity)
        //{
        //    rb.velocity = new Vector2(constantSpeed, 0f); // Maintain constant horizontal speed
        //}

    }
}
