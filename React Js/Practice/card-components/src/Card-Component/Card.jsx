import profile from '../assets/profile.jpg';
import './Card.css';
function Card(){
    
    return(

        <div className="card">
            <img className="card-image" src={profile} alt="profile-picture" />
            <h2 className="card-title">PISTI<br/>Jacinth</h2>
            <p className="card-desc">An aspiring back-end developer, currently
                a 2nd year college student.
            </p>   
        </div>

    );

}
export default Card