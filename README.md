# Dict_ST5
 This Desktop Application built using Java , Swing (Java GUI library) and sqlite is a Library Manager.
 
 It allows to a simple user to:

 - consult his personal data (name , birthday...) ([UserInfoPanel](src/View_Control/Navigation/UserInfoPanel.java))
 - check the books he or she borrowed and the date each of them needs to be returned ([UserInfoPanel](src/View_Control/Navigation/UserInfoPanel.java))
 - look up the books that are in the library and borrow them if there is any left ([BookInfoPanel](src/View_Control/Navigation/BookInfoPanel.java))

 And to an administrator, it allows to do everything a simple user can do plus :
 - Look up a user of the library ([UserInfoPanel](src/View_Control/Navigation/UserInfoPanel.java))
 - Edit a User's personal data or Delete a User ([EditUserPanel](src/View_Control/Navigation/EditUserPanel.java))
 - Edit a Book's Data to change for example its remaining Field when some one returns it. ( [EditBookPanel](src/View_Control/Navigation/EditBookPanel.java))
 - Add or Delete a Book from the database. ([EditBookPanel](src/View_Control/Navigation/EditBookPanel.java))


**Modelisation of the Front classes without the controllers**


![Alt text](Modelisation/Front.png?raw=true FrontAPI)


**Modelisation of the Back API**

![Alt text](Modelisation/BackAPI.png?raw=true BackAPI)