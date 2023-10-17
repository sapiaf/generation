const taskHeadings = document.querySelectorAll('h2')
const addTaskButton = document.querySelector('.add-task')
const addSectionButton = document.querySelector('.add-section')
const tasks = document.querySelectorAll('.task')

taskHeadings.forEach(heading => heading.addEventListener('click', closeTaskList))
addTaskButton.addEventListener('click', addTask)
addSectionButton.addEventListener('click', addSection)
tasks.forEach(task => task.addEventListener('dblclick', removeTask))



function removeTask(event) {
    const task = event.target
    task.style.display = 'none';
}



function addSection() {
    const sectionName = prompt('Write a new section name...')
    const containerTasks = document.querySelector('.container__tasks')

    const newSection = document.createElement('section')
    newSection.classList.add(`container__tasks-${sectionName}`)

    const sectionHeading = document.createElement('h2')
    sectionHeading.textContent = sectionName

    const sectionSpan = document.createElement('span')
    sectionSpan.innerHTML = '&#x25BE'
    sectionSpan.classList.add('arrow')

    sectionHeading.insertBefore(sectionSpan, sectionHeading.firstChild)
    newSection.appendChild(sectionHeading)
    containerTasks.appendChild(newSection)
}


function addTask() {
    const taskText = prompt('Write your task...')
    // const taskCategory = prompt('Write your category')
    const tasksList = document.querySelector('.container__tasks-new')

    const newTask = document.createElement('div')
    newTask.classList.add('.task')

    const checkbox = document.createElement('input')
    checkbox.type = 'checkbox'
    checkbox.id = taskText.toLowerCase().split(' ').join('-')
    checkbox.value = taskText
    checkbox.classList.add('container__tasks-new-checkbox');
    checkbox.name = "task_checkbox"

    const label = document.createElement('label')
    label.htmlFor = taskText.toLowerCase().split(' ').join('-')
    label.textContent = taskText

    newTask.append(checkbox, label)
    tasksList.append(newTask)
}



function closeTaskList(event) {
    const tasksList = event.target.nextElementSibling;
    const arrow = event.target.querySelector('.arrow');

    tasksList.classList.toggle('closed');
    arrow.textContent = tasksList.classList.contains('closed') ? '\u25B4' : '\u25BE';
}
