# Caminho base onde estão as pastas dos alunos
$basePath = "entrega02"

# Pega todas as pastas dentro do caminho base
$folders = Get-ChildItem -Path $basePath -Directory

foreach ($folder in $folders) {
    # Extrai o nome do aluno (antes do primeiro "_")
    $studentName = ($folder.Name -split "_")[0]

    # Encontra o arquivo XML dentro da pasta
    $xmlFiles = Get-ChildItem -Path $folder.FullName -Filter "*.xml"

    foreach ($xml in $xmlFiles) {
        # Define o novo nome do arquivo (mesmo diretório, nome do aluno + .xml)
        $newName = "$studentName.xml"
        $newPath = Join-Path $folder.FullName $newName

        # Renomeia o arquivo
        Rename-Item -Path $xml.FullName -NewName $newName -Force
        Write-Host "Renomeado: $($xml.Name) -> $newName"
    }
}

