# Caminho base onde estão as pastas dos alunos
$basePath = "entrega03"

# Pega todas as pastas dentro do caminho base
$folders = Get-ChildItem -Path $basePath -Directory

foreach ($folder in $folders) {

    # Extrai o nome do aluno (antes do primeiro "_")
    $studentName = ($folder.Name -split "_")[0]

    # Procura arquivos .zip ou .rar dentro da pasta
    $compressedFiles = Get-ChildItem -Path $folder.FullName -File | Where-Object {
        $_.Extension -in ".zip", ".rar", ".tar", ".gz"
    }

    foreach ($file in $compressedFiles) {

        # Define o novo nome mantendo a extensão original
        $newName = "$studentName$($file.Extension)"

        # Renomeia o arquivo
        Rename-Item -Path $file.FullName -NewName $newName -Force

        Write-Host "Renomeado: $($file.Name) -> $newName"
    }
}