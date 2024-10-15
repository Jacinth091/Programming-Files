const cart = ['Banana', 'Apple', 'Orange', 'Grapes'];
function UserCart(){

    const sortedCart = cart.sort((a, b) => a.localeCompare(b));
    
    return(         
        <ul>
            {cart.map((item, index) => (
            <li key={index}>{item}</li>
            ))}
        </ul>

    );
    

}

export default UserCart;