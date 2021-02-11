(function () {
    var $usernameFld, $passwordFld, $firstNameFld, $lastNameFld, $roleFld;
    var $searchBtn, $createBtn, $updateBtn;
    var $removeBtn, $editBtn;
    var $tbody;
    var userService = new AdminUserServiceClient();
    var users;
    var currentUser;
    $(main);

    function main() {
        users = []
        currentUser = null;
        $usernameFld = $('#usernameFld');
        $passwordFld = $('#passwordFld');
        $firstNameFld = $('#firstNameFld');
        $lastNameFld = $('#lastNameFld');
        $roleFld = $('#roleFld');
        $createBtn = $('.wbdv-create');
        $updateBtn = $('.wbdv-update');
        $searchBtn = $('.wbdv-search');
        $createBtn.click(createUser);
        $updateBtn.click(updateUser);
        $tbody = $('.wbdv-tbody');
        findAllUsers()
    }

    function clearFields() {
            $usernameFld.val('')
            $passwordFld.val('')
            $firstNameFld.val('')
            $lastNameFld.val('')
            $roleFld.val('FACULTY')
    }

    function createUser() {
        const newUser = {
            username: $usernameFld.val(),
            password: $passwordFld.val(),
            firstName: $firstNameFld.val(),
            lastName: $lastNameFld.val(),
            role: $roleFld.val()
        };
        userService.createUser(newUser).then((serverUser) => {
            users.push(serverUser);
            renderUsers(users);
        })
        clearFields();
    }

    function deleteUser(event) {
        let deleteBtn = $(event.target);
        let id = deleteBtn.attr('id');
        id = users[id]._id;
        users = users.filter((user) => user._id !== id);
        userService.deleteUser(id).then(() => {
            renderUsers(users);
        });
    }

    function selectUser(event) {
        let editBtn = $(event.target);
        let id = editBtn.attr('id');
        currentUser = users.find((user) => user._id === id);
        $usernameFld.val(currentUser.username);
        $passwordFld.val(currentUser.password);
        $firstNameFld.val(currentUser.firstName);
        $lastNameFld.val(currentUser.lastName);
        $roleFld.val(currentUser.role);
    }

    function updateUser() {
        if (currentUser) {
            currentUser.username = $usernameFld.val();
            currentUser.password = $passwordFld.val();
            currentUser.firstName = $firstNameFld.val();
            currentUser.lastName = $lastNameFld.val();
            currentUser.role = $roleFld.val();
            userService.updateUser(currentUser._id, currentUser).then(() => {
                renderUsers(users);
                currentUser = null;
                clearFields();
            });
        } else {
            alert('Must select a user.')
        }
    }

    function renderUsers(users) {
        $tbody.empty();
        for (let i = 0; i < users.length; i++) {
            user = users[i]
            $tbody.append(`<tr>
                              <td>${user.username}</td>
                              <td></td>
                              <td>${user.firstName}</td>
                              <td>${user.lastName}</td>
                              <td>${user.role}</td>
                              <td>
                                  <span class='pull-right wbdv-nowrap-right-align'>
                                      <button class='btn btn-light fas fa-times wbdv-remove' id='${i}'/>
                                      <button class='btn btn-light fas fa-pencil wbdv-edit' id='${user._id}'/>
                                  </span>
                              </td>
                          </tr>`)
        }
        $removeBtn = $('.wbdv-remove').click(deleteUser);
        $editBtn = $('.wbdv-edit').click(selectUser);
    }

    function findAllUsers() { // optional - might not need this
        userService.findAllUsers().then((usersFound) => {
            users = usersFound;
            renderUsers(users);
        });
    }

    function findUserById() { // optional - might not need this
        return userService.findUserById(currentUser._id).then(user => user);
    }
})();