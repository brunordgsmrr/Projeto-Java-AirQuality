export default class ParameterInfoView {
    constructor() {
        this.modal = document.getElementById('parameter-info-modal');
        this.closeButton = this.modal.querySelector('.close-btn');
        this.closeButton.onclick = () => this.close();
    }

    open(parameter) {
        this.modal.querySelector('.parameter-name').textContent = parameter.name;
        this.modal.querySelector('.parameter-description').textContent = parameter.description;
        this.modal.querySelector('.parameter-unit').textContent = parameter.unit;

        this.modal.style.display = 'block';
    }

    close() {
        this.modal.style.display = 'none';
    }
}