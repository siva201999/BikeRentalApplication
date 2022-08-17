export class Config {
    Login={
        email:"",
        password:""
        
    }
    
    userRole={
        userType:""
    }

    Signup={
        email:"",
        password:"",
        mobileNumber:"",
        userName:"",
        gender:"",
        userRole:"",
        image!:"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNSAUZ37P2k0ugD36-kOgGrAjK6gLMWKXnyw&usqp=CAU",
        address:"",
        earnings!:0,
        isActive!:"true"
    }

    CustomerObj={
        id:0,
        email:"",
        password:"",
        mobileNumber:"",
        userName:"",
        gender:"",
        userRole:"",
        image!:"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNSAUZ37P2k0ugD36-kOgGrAjK6gLMWKXnyw&usqp=CAU",
        address:"",
        isActive!:"true" 
    }
    RenterObj={
        id:0,
        email:"",
        password:"",
        mobileNumber:"",
        userName:"",
        gender:"",
        userRole:"",
        image:"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNSAUZ37P2k0ugD36-kOgGrAjK6gLMWKXnyw&usqp=CAU",
        address:"",
        earnings!:0,
        isActive!:"true"
    }

    BikeObj={
        id:"",
        brandName:"",
        modelName:"",
        bikeNumber:"",
        bikeImage:"",
        description:"",
        rentAmount:"",
        pickUpLocation:"",
        availability:"",
    }
   Comments={
    id:"",
    email:"",
    name:"",
    feedback:"",
   }

  static Login: object;
  static CustomerObj: [];
  static RenterObj: [];
  static BikeObj: [];
  static Comments:{};
}
