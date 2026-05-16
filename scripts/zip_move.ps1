# Caminho base onde estão as pastas dos alunos
$basePath = "entrega03"

# Pega todas as pastas dentro do caminho base
$folders = Get-ChildItem -Path $basePath -Directory

foreach ($folder in $folders) {

    # Extrai o nome do aluno antes do primeiro "_"
    $studentName = ($folder.Name -split "_")[0]

    # Encontra arquivos ZIP ou RAR dentro da pasta
    $compressedFiles = Get-ChildItem -Path $folder.FullName -File | Where-Object {
        $_.Extension -in ".zip", ".rar", ".tar", ".gz"
    }

    foreach ($file in $compressedFiles) {

        # Define novo nome mantendo a extensão original
        $newName = "$studentName$($file.Extension)"
        $newPath = Join-Path $folder.FullName $newName

        # Renomeia dentro da pasta
        Rename-Item -Path $file.FullName -NewName $newName -Force
        Write-Host "Renomeado: $($file.Name) -> $newName"

        # Caminho de destino no diretório pai
        $destination = Join-Path $basePath $newName

        # Copia para o diretório base
        Copy-Item -Path $newPath -Destination $destination -Force
        Write-Host "Copiado para: $destination"
    }
}