function addCar(file, brand, model) {
    var formData = new FormData();
    formData.append("file", file);
    formData.append("brand", brand);
    formData.append("model", model);
    $.ajax({
        type: 'POST',
        contentType: false,
        processData: false,
        url: "/add/car",
        data: formData
    });
}