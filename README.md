# logica-rh developpe par Ngor SECK - ngorsecka@gmail.com

### Departments end points
    ####get mothod for getting all departments --- > http://localhost:8889/departments
    ####post mothod for creating a department --- > http://localhost:8889/departments

        #####{
                "name": "Communication",
                "responsable": {
                        "id": 2,
                        "firstName": "SECK",  
                        "lastName": "Ngor", 
                        "gender": "M", 
                        "country": "Senegalaise", 
                        "city": "Senegal", 
                        "adress": "Wakhade Bargny - Dakar"
                    }
            }
    ####put method for updating a department --- > http://localhost:8889/departments/name
    #########{
                "name": "Communication",
                "responsable": {
                        "id": 2,
                        "firstName": "SECK",  
                        "lastName": "Ngor", 
                        "gender": "M", 
                        "country": "Senegalaise", 
                        "city": "Senegal", 
                        "adress": "Wakhade Bargny - Dakar"
                    }
            }
    ####delete method for deleting a department --- > http://localhost:8889/departments/name



