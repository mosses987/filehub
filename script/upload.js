
function handleSubmit() {
    let formData = new FormData();           
    formData.append("file", fileupload.files[0]);
    fetch('http://localhost:9090/file/upload', {
      method: "POST", 
      body: formData
    }).then(res=>console.log(res)).catch(err=>console.log(err));

    alert('The file has been uploaded successfully.');
}
