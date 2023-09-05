document.addEventListener("DOMContentLoaded", function () {
    const taskInput = document.getElementById("task");
    const addTaskButton = document.getElementById("add-task");
    const inProgressList = document.getElementById("in-progress-list");
    const completeList = document.getElementById("complete-list");

    addTaskButton.addEventListener("click", function () {
        const taskText = taskInput.value.trim();

        if (taskText !== "") {
            const li = document.createElement("li");
            li.innerHTML = `
                <span>${taskText}</span>
                <button class="complete-button">Complete</button>
                <button class="delete-button">Delete</button>`;

            const completeButton = li.querySelector(".complete-button");
            const deleteButton = li.querySelector(".delete-button");

            completeButton.addEventListener("click", function () {
                moveTaskToComplete(li);
            });

            deleteButton.addEventListener("click", function () {
                removeTask(li);
            });

            inProgressList.appendChild(li);
            taskInput.value = "";
        }
    });

    function moveTaskToComplete(taskItem) {
        inProgressList.removeChild(taskItem);
        taskItem.querySelector(".complete-button").remove();
        taskItem.querySelector(".delete-button").remove();
        completeList.appendChild(taskItem);
    }

    function removeTask(taskItem) {
        if (inProgressList.contains(taskItem)) {
            inProgressList.removeChild(taskItem);
        } else if (completeList.contains(taskItem)) {
            completeList.removeChild(taskItem);
        }
    }

    taskInput.addEventListener("keyup", function (event) {
        if (event.key === "Enter") {
            addTaskButton.click();
        }
    });
});
